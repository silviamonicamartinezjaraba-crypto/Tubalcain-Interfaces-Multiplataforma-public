@echo off
chcp 65001 > nul

:: Fuerza al script a situarse en la carpeta del repositorio
cd /d "%~dp0"

echo ===========================================
echo       CREAR NUEVA RAMA PARA EXAMEN / TAREA
echo ===========================================

:: 1. Comprobar que existe el repositorio
if not exist ".git" (
    echo [ERROR] No se encuentra la carpeta .git.
    pause
    exit /b
)

:: 2. Preguntar el nombre de la nueva rama
set /p NOMBRE_RAMA="Escribe el nombre de la nueva rama (ej: examen-t1): "

if "%NOMBRE_RAMA%"=="" (
    echo [ERROR] Debes escribir un nombre valido.
    pause
    exit /b
)

:: 3. Asegurar que partimos de la base limpia del profesor (main)
echo.
echo Preparando la base desde 'main'...
git checkout main
git pull upstream main --allow-unrelated-histories > nul 2>&1

:: 4. Crear la nueva rama y cambiarse a ella
git checkout -b %NOMBRE_RAMA%

:: 5. Subir la rama vacía a tu GitHub
echo Subiendo la nueva rama a tu GitHub...
git push -u origin %NOMBRE_RAMA%

echo.
echo ===========================================
echo   Rama '%NOMBRE_RAMA%' creada y lista!
echo   Ya estas trabajando sobre ella.
echo ===========================================
pause