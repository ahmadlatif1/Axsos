from flask import Flask, render_template, request, redirect 
app = Flask(__name__) 

@app.route('/')          
def load_page():
    return render_template("login.html")  

@app.route('/result', methods=['POST'])
def submit_info():
    print("Got Post Info")
    print(request.form)
    form_name=request.form["name"]
    form_location=request.form["location"]
    form_language=request.form["language"]
    form_comment=request.form["comment"]
    # name_from_form = request.form['name']
    
    return render_template("result.html", name=form_name, location=form_location, language=form_language, comment=form_comment)

if __name__=="__main__":      
    app.run(debug=True)  