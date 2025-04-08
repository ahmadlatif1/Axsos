from django.http import JsonResponse
from django.shortcuts import redirect, render, HttpResponse

def index(request):
    return redirect("/blogs")

def root(request):
    return  HttpResponse("hello")

def new(request):
    return HttpResponse("placeholder for new")

def create(request):
    return redirect("/")

def show(request,num):
    return HttpResponse("placeholder to return blog number"+str(num))

def edit(request,num):
    return HttpResponse("placeholder to edit blog number"+str(num))


def destroy(request,num):
    return redirect("/blogs")

def get_json(request):
    info={
        "title":"my first blog",
        "content":"lorem ipsum something"
    }
    return JsonResponse(info)