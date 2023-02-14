# Python Webhooks Project
An example of webhooks python verification process.

# Installation
1. Install all dependencies.
```bash
composer install
```
2. Run server
```bash
symfony server:start
```

3. Add file webhooks-public.cer to public/ folder.
4. Verify webhook signature passes by sending a payload of the webhook with the elmo-webhook-signature header.