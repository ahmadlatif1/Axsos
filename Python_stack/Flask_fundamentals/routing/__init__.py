from flask import Flask,render_template  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"
@app.route('/')          # The "@" decorator associates this route with the function immediately following
def hello_world():
    return render_template('index.html')
    

    
@app.route('/<word>')
def word(word): return f'{word}!'

@app.route('/say/<word>')
def say (word): return f'Hi {word}!'

@app.route('/repeat/<n>/<word>')
def repeat(word,n): return int(n)*f'Hi {word}!<br>'

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.
