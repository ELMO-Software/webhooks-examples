var fs = require('fs');
var crypto = require('crypto');
import app from './../app.js';

app.use('/webhooks', function(req, res, next) {
    const signature = req.get("elmo-webhook-signature");
    const payload = JSON.stringify(req.body);
    const certificate = fs.readFileSync("./webhooks-public.cer", "utf8");
    const publicKey = crypto.createPublicKey(certificate).export({type:'spki', format:'pem'}).slice(0, -1);
    const verifier = crypto.createVerify('SHA256');
    verifier.update(payload);
    result = verifier.verify(publicKey, signature, 'base64');
    
    if (result) {
        next()
    }
    else {
        res.status(403).send("Invalid signature")
    }
    res.send(result);
});
