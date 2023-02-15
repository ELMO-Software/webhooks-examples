var express = require('express');
var router = express.Router();
var fs = require('fs');
var crypto = require('crypto');

router.use((req, res, next) => {
  const signature = req.get("elmo-webhook-signature");
  const payload = JSON.stringify(req.body);
  const certificate = fs.readFileSync("./webhooks-public.cer", "utf8");
  const publicKey = crypto.createPublicKey(certificate).export({type:'spki', format:'pem'}).slice(0, -1);
  const verifier = crypto.createVerify('SHA256');
  verifier.update(payload);
  verifier.verify(publicKey, signature, 'base64') ? 
    next() : res.status(403).send("Invalid signature")
});

router.post('/webhooks', function(req, res, next) {
  res.send("Signature verified")
});

module.exports = router;
