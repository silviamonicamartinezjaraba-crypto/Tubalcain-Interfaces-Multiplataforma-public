@echo off
chcp 65001 > nul
echo ===========================================
echo       GUARDANDO TUS CAMBIOS EN GIT
echo ===========================================

:: Nos aseguramos de estar en tu rama personal
git checkout mi-trabajo

:: Comprobamos si hay cambios
git status --porcelain > temp_status.txt
set /p STATUS=<temp_status.txt
del temp_status.txt

if "%STATUS%"=="" (
    echo No hay cambios nuevos que guardar.
    pause
    exit /b
)

:: Pide un mensaje para el commit (si pulsas Enter pone uno por defecto)
set /p MENSAJE="Escribe que has hecho (o pulsa ENTER para mensaje automatico): "
if "%MENSAJE%"=="" set MENSAJE=Avances en mi trabajo

:: Guarda y sube
git add .
git commit -m "%MENSAJE%"
git push origin mi-trabajo

echo.
echo ===========================================
echo   Tus cambios se han subido a tu GitHub!
echo ===========================================
pause