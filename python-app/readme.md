# Python Webhooks Project
An example of webhooks python verification process.

# Installation
1. Create a virtual environment.
```bash
python3 -m venv venv
```
2. Enter the virtual environment.

| Platform | Shell  | Second Header |
| - | - | - |
| Posix | bash/zsh  | source venv/bin/activate |
|| fish  | source venv/bin/activate.fish | 
|| csh/tcsh | source venv/bin/activate.csh |
| Windows | cmd.exe  | venv\Scripts\activate.bat | 
|| PowerShell | venv\Scripts\Activate.ps1 |


3. Install all dependencies.
```bash
pip install -r requirements.txt
```
4. Run server
```bash
python -m flask --app main run
```

5. Add file webhooks-public.cer to the root of your directory
6. Verify webhook signature passes by sending a payload of a webhook with the elmo-webhook-signature header.