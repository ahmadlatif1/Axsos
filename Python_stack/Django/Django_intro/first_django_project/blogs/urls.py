from django.urls import path     
from . import views
urlpatterns = [
    path('', views.index),       
    path('blogs',views.root),
    path('blogs/new',views.new),
    path("blogs/create", views.create),
    path("blogs/<int:num>",views.show),
    path("blogs/<int:num>/edit",views.edit),
    path("blogs/<int:num>/delete",views.destroy),
    path("blogs/json",views.get_json)
]