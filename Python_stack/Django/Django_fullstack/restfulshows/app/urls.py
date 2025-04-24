from django.urls import path
from . import views 

urlpatterns = [
    path('', views.index),
    path('shows/',views.index),
    path('shows/new/',views.newshow),
    path('shows/<int:id>/',views.showdetail),
    path('shows/<int:id>/edit/', views.editshow),
    path('shows/update/<int:id>/', views.updateshow),
    path('shows/<int:id>/delete/', views.deleteshow),
]