from django.urls import path
from . import views 

urlpatterns = [
    path('', views.index),
    path('newdojo/',views.new_dojo),
    path('newninja/', views.new_ninja),
]