from time import gmtime, strftime
from django.shortcuts import render

# Create your views here.

def index(request):
    context = {
        "time": strftime("%Y-%m-%d %H:%M %p", gmtime()),
        "test": "test"
    }
    print("TIME AAAAAAA",context)

    return render(request,'index.html', context)
