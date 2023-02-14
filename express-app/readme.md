# PHP Webhooks Project
An example of webhooks express nodejs verification process.

# Installation
1. Install all dependencies.
```bash
npm install
```
2. Run server
```bash
npm start
```

3. Add file webhooks-public.cer to root folder.
4. Verify webhook signature passes by sending a payload of the webhook with the elmo-webhook-signature header.