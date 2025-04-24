from django.shortcuts import render
from django.shortcuts import render, redirect
from .models import *

def index(request):
    context = {
        "shows": Show.objects.all()
    }
    return render(request,"index.html",context)

def newshow(request):
    if request.method == "POST":
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
    c = Show.objects.get(id=id)
    c.title = request.POST['title']
    c.network = request.POST['network']
    c.release_date = request.POST['release_date']
    c.description = request.POST['description']
    c.save()
    return redirect(f"/shows/{id}/")

def deleteshow(request,id):
    c = Show.objects.get(id=id)
    c.delete()
    return redirect("/shows/")