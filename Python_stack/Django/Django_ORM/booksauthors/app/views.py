from django.shortcuts import redirect, render

from app.models import *


def index(request):
    books = Book.objects.all()


    return render(request, 'index.html', {'books': books})


def add_book(request):
    if request.method=="POST":
        title = request.POST.get('title')
        description = request.POST.get('description')
        book = Book(title=title, description=description)
        book.save()
        print(book)
    return redirect('/')
    

def book_detail(request, id):
    book = Book.objects.get(id=id)
    associated_authors = book.authors.all()
    available_authors = Author.objects.exclude(id__in=associated_authors.values_list('id', flat=True))
    return render(request, 'books.html', {'book': book, 'authors': associated_authors, 'available_authors':available_authors})


def authors(request):
    authors = Author.objects.all()
    return render(request, 'authors.html', {'authors': authors})


def add_author(request):
    if request.method=="POST":
        first_name = request.POST.get('first_name')
        last_name = request.POST.get('last_name')
        notes = request.POST.get('notes')
        author = Author(first_name=first_name, last_name=last_name, notes=notes)
        author.save()
        return redirect('/authors')
    
def author_detail(request, id):
    author = Author.objects.get(id=id)
    books = author.books.all()
    all_books = Book.objects.all()
    if request.method == "POST":
        book_id = request.POST.get('book')
        book = Book.objects.get(id=book_id)
        author.books.add(book)
        author.save()
    return render(request, 'authorsdetail.html', {'author': author, 'books': books, 'all_books':all_books})


def add_book_to_author(request, id):
    author = Author.objects.get(id=id)
    if request.method == "POST":
        
        book_id = request.POST.get('book_id')
        try:
            book = Book.objects.get(id=book_id)
            author.books.add(book)
        except Book.DoesNotExist:
            # Handle the case where the book does not exist
            return redirect(f'/authors/{id}')  # Redirect back to the author detail page or display an error message
    author.save()
    
    associated_books = author.books.all()
    available_books = Book.objects.exclude(id__in=associated_books.values_list('id', flat=True))
    return render(request, 'authorsdetail.html', {'author': author, 'books': associated_books, 'all_books':available_books})

def add_author_to_book(request, id):
    book = Book.objects.get(id=id)
    if request.method == "POST":
        author_id = request.POST.get('author_id')
        try:
            author = Author.objects.get(id=author_id)
            book.authors.add(author)
        except Author.DoesNotExist:
            # Handle the case where the author does not exist
            return redirect(f'/books/{id}')  # Redirect back to the book detail page or display an error message
    book.save()
    
    associated_authors = book.authors.all()
    available_authors = Author.objects.exclude(id__in=associated_authors.values_list('id', flat=True))
    return render(request, 'books.html', {'book': book, 'authors': associated_authors, 'available_authors':available_authors})