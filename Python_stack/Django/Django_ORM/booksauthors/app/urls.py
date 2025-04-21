from django.urls import path
from . import views 

urlpatterns = [
    path('', views.index),
    path('authors/', views.authors),
    path('books/<int:id>/', views.book_detail),
    path('books/<int:id>/add_author/', views.add_author_to_book),  # add book to author here replace this
    path('add_author/', views.add_author),
    path('add/',views.add_book),
    path('authors/<int:id>/', views.author_detail),
    path('authors/<int:id>/add_book/', views.add_book_to_author),  # add author to book here replace this
]

