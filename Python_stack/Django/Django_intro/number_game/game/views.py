import random
from django.shortcuts import render

# Create your views here.
def index(request):

    if 'goal' not in request.session:
        request.session['goal']=random.randint(0,100)
    

    
    context={
        "input":0,
        "submitted":False,
        "goal":request.session['goal'],
        "bg_color":"#cf2a28"
    }
    
    if request.method == "POST":
        if request.POST["custId"]=='input':
            context['input']=int(request.POST["input"])
            context['submitted']=True
            if context['goal']==context['input']:
                context['bg_color']="#009d0e" 
        else:
            request.session['goal']=random.randint(0,100)

    
    
        
        
    print('rendering with:',context)
        
    return render(request,"index.html",context)