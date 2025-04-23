from flask import Flask, render_template, request, redirect
app = Flask(__name__)  


@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    print(request.form)
    form=request.form
    numitems=int(form['strawberry'])+int(form['raspberry'])+int(form['apple'])
    return render_template("checkout.html",form=form,items=numitems)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    
    