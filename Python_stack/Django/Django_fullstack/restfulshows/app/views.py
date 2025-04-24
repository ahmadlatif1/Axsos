from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *

def index(request):
    context = {
        "shows": Show.objects.all()
    }
    return render(request,"index.html",context)

def newshow(request):
    if request.method == "POST":
        errors = Show.objects.validate(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect("/shows/new")
        else:
            title = request.POST['title']
            network = request.POST['network']
            release_date = request.POST['release_date']
            description = request.POST['description']
            Show.objects.create(title=title, network=network, release_date=release_date, description=description)
            return redirect(f"/shows/{Show.objects.last().id}/")
    return render(request,"addshow.html")

def showdetail(request,id):
    context = {
        "show": Show.objects.get(id=id)
    }
    return render(request,"showdetail.html",context)

def editshow(request,id):
    context = {
        "show": Show.objects.get(id=id)
    }
    return render(request,"editshow.html",context)

def updateshow(request,id):
    if request.method == "POST":
        errors = Show.objects.validate(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect(f"/shows/{id}/edit")
        else:
            show = Show.objects.get(id=id)
            show.title = request.POST['title']
            show.network = request.POST['network']
            show.release_date = request.POST['release_date']
            show.description = request.POST['description']
            show.save()
            return redirect(f"/shows/{id}/")
    return redirect(f"/shows/{id}/edit") # Handle GET requests to this URL

def deleteshow(request,id):
    show = Show.objects.get(id=id)
    show.delete()
    return redirect("/shows/")
