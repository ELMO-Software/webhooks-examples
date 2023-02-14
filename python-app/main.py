import base64

from flask import Flask, jsonify, request
from OpenSSL import crypto

app = Flask(__name__)

@app.route("/webhooks", methods = ['POST'])
def webhooks():
    signature = base64.b64decode(request.headers.get('elmo-webhook-signature'))
    payload = request.data.decode()
    isVerified = False
    
    with open('webhooks-public.cer', 'r') as f: 
        certificate = crypto.load_certificate( crypto.FILETYPE_PEM, f.read())
    
    try: 
        crypto.verify(certificate, signature, payload, "sha256")
        isVerified = True
    except:
        pass
    
    return jsonify(isVerified=isVerified)
    
    