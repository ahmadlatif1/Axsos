from flask import Flask,render_template 
app = Flask(__name__)   


def makeboard(x=8,y=8):
    return render_template('index.html',row=int(x),box=int(y))

app.route('/')(makeboard)
app.route('/<x>')(makeboard)
app.route('/<x>/<y>')(makeboard)





if __name__=="__main__":   
    app.run(debug=True)    




