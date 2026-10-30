@echo off
chcp 65001 > nul
cd /d "%~dp0"

echo ========================================================
echo       DESCARGANDO ACTUALIZACIONES DEL PROFESOR
echo ========================================================

:: Comprobar que existe el repositorio
if not exist ".git" (
    echo [ERROR] No se encuentra la carpeta .git.
    pause
    exit /b
)

:: Apartar cambios temporales si existieran
git stash > nul 2>&1

:: Cambiar a la rama main
echo Cambiando a la rama main...
git checkout main

:: Descargar lo nuevo del profesor y forzar la sincronizacion limpia
echo Descargando lo nuevo del repositorio del profesor...
git fetch upstream
git reset --hard upstream/main

:: Respaldar la copia limpia en tu propio GitHub
echo Guardando copia limpia en tu GitHub...
git push origin main --force

:: Devolverte a tu rama personal de trabajo
echo.
echo Volviendo a tu rama personal 'mi-trabajo'...
git checkout mi-trabajo
git stash pop > nul 2>&1

echo.
echo ========================================================
echo   ¡Listo! Las novedades del profesor estan en 'main'.
echo   Tu codigo personal en 'mi-trabajo' sigue intacto.
echo ========================================================
pause