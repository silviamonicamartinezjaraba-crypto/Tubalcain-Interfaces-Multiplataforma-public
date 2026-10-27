@echo off
chcp 65001 > nul
echo ===========================================
echo    ACTUALIZANDO CODIGO DEL PROFESOR
echo ===========================================

:: 1. Guardar cualquier cambio que tengas pendiente en tu rama para no perderlo
git checkout mi-trabajo
git add .
git commit -m "Autoguardado antes de actualizar del profesor" > nul 2>&1

:: 2. Actualizar la rama main con lo del profesor
echo Descargando lo nuevo del repositorio del profesor...
git checkout main
git pull upstream main --allow-unrelated-histories
git push origin main

:: 3. Traer las novedades de main a tu rama mi-trabajo
echo.
echo Integrando las novedades en tu rama 'mi-trabajo'...
git checkout mi-trabajo
git merge main -m "Fusion con novedades del profesor"
git push origin mi-trabajo

echo.
echo ===========================================
echo   Proyecto actualizado y sincronizado!
echo ===========================================
pause