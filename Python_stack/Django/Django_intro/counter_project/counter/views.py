from django.shortcuts import render,redirect

# Create your views here.
def index(request):

    print("session start")

    if 'count' not in request.session:
        request.session['count']=1
    else:
        request.session['count']=request.session['count']+1
        print("session added")

    return render(request,"index.html",{"count":request.session['count']})

def destroy(request):
    request.session['count']=0
    return(redirect("/"))