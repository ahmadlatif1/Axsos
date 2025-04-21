from django.shortcuts import redirect, render
from users_app.models import *

def index(request):


    users = User.objects.all()
    return render(request,"index.html", {'users': users})


def create_user(request):
    if request.method == 'POST':
        first_name = request.POST.get('first_name')
        last_name = request.POST.get('last_name')
        email = request.POST.get('email_address')
        age = request.POST.get('age')
        user = User.objects.create(first_name=first_name, last_name=last_name, email_address=email, age=age)
        user.save()
    return redirect('/')