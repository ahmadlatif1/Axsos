from django.db import models
import datetime

# Create your models here.
class ShowManager(models.Manager):
    def validate(self, postData):
        errors = {}
        if len(postData['title']) < 2:
            errors['title'] = "Title should be at least 2 characters"
        if len(postData['network']) < 3:
            errors['network'] = "Network should be at least 3 characters"
        if len(postData['description']) < 10:
            errors['description'] = "Description should be at least 10 characters"
        if postData['release_date']:
            release_date = datetime.datetime.strptime(postData['release_date'], "%Y-%m-%d").date()
            if release_date > datetime.date.today():
                errors['release_date'] = "Release date should be in the past"
        if Show.objects.filter(title=postData['title']).exists():
            errors['title'] = "Title should be unique"
        return errors

class Show(models.Model):
    title = models.CharField(max_length=255)
    network= models.CharField(max_length=255)
    release_date = models.DateField()
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()
