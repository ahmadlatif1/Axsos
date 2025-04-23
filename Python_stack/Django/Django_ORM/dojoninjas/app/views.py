from django.shortcuts import redirect, render
from app.models import *
# Create your views here.
# for copilot, these are the classes in models.py for your reference
# class dojo(models.Model):
#     name = models.CharField(max_length=100)
#     city = models.CharField(max_length=100)
#     state = models.CharField(max_length=100)
# class ninja(models.Model):
#     first_name = models.CharField(max_length=100)
#     last_name = models.CharField(max_length=100)
#     dojo = models.ForeignKey(dojo, related_name="ninjas", on_delete=models.CASCADE)

def index(request):
    context = {
        'dojos': Dojo.objects.all(),
        'ninjas': Ninja.objects.all()
    }
    return render(request, 'index.html', context)


def new_dojo(request):
    if request.method == 'POST':
        
        dojo_name = request.POST.get('dojo_name')
        dojo_city = request.POST.get('dojo_city')
        dojo_state = request.POST.get('dojo_state')
        

        new_dojo = Dojo(name=dojo_name, city=dojo_city, state=dojo_state)
        new_dojo.save()
        context={}
        
    return redirect('/',)


def new_ninja(request):

    if request.method == 'POST':
        ninja_first_name = request.POST.get('first_name')
        ninja_last_name = request.POST.get('last_name')
        dojo_id = request.POST.get('dojo_id')
        
        new_ninja = Ninja(first_name=ninja_first_name, last_name=ninja_last_name, dojo_id=dojo_id)
        new_ninja.save()
        
    return redirect('/')
