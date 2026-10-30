@echo off
chcp 65001 > nul
cd /d "%~dp0"

echo ========================================================
echo       GUARDANDO TUS CAMBIOS EN GIT
echo ========================================================

:: 1. Comprobar que existe el repositorio
if not exist ".git" (
    echo [ERROR] No se encuentra la carpeta .git en este directorio.
    pause
    exit /b
)

:: 2. Asegurarnos de que estamos en tu rama personal
git checkout mi-trabajo

:: 3. Comprobar si hay cambios pendientes
git status --porcelain > temp_status.txt

for %%A in (temp_status.txt) do (
    if %%~zA==0 (
        del temp_status.txt
        echo No hay cambios nuevos que guardar.
        pause
        exit /b
    )
)
del temp_status.txt

:: 4. Pedir mensaje para el commit
echo Hay cambios pendientes detectados.
set /p MENSAJE="Escribe que has hecho (o pulsa ENTER para mensaje automatico): "
if not defined MENSAJE set MENSAJE=Avances en mi trabajo

:: 5. Guardar y subir a tu GitHub
echo Subiendo tus cambios a GitHub...
git add .
git commit -m "%MENSAJE%"
git push -u origin mi-trabajo

echo.
echo ========================================================
echo   ¡Tus cambios se han subido a tu GitHub!
echo ========================================================
pause