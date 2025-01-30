@echo off
REM Quellverzeichnis definieren
SET SOURCE_DIR="C:\Users\mikel\IdeaProjects\Bachelorarbeit\Bachelorarbeit_ManuellTests\src"

REM Zielverzeichnisse definieren
SET TARGET_DIR1="C:\Users\mikel\IdeaProjects\Bachelorarbeit\Bachelorarbeit_GitHub\src"
SET TARGET_DIR2="C:\Users\mikel\IdeaProjects\Bachelorarbeit\Bachelorarbeit_Diffblue\src"
SET TARGET_DIR3="C:\Users\mikel\IdeaProjects\Bachelorarbeit\Bachelorarbeit_EVOSuite\src"

REM Ordnerliste definieren, die kopiert werden sollen
SET FOLDERS_TO_COPY="datastructures" "exceptions" "generic" "resources" "services"

REM Schleife über alle definierten Ordner
for %%F in (%FOLDERS_TO_COPY%) do (
    echo Kopiere %%F von %SOURCE_DIR% nach %TARGET_DIR1%...
    xcopy /E /Y %SOURCE_DIR%\%%F %TARGET_DIR1%\%%F
)
for %%F in (%FOLDERS_TO_COPY%) do (
    echo Kopiere %%F von %SOURCE_DIR% nach %TARGET_DIR2%...
    xcopy /E /Y %SOURCE_DIR%\%%F %TARGET_DIR2%\%%F
)
for %%F in (%FOLDERS_TO_COPY%) do (
    echo Kopiere %%F von %SOURCE_DIR% nach %TARGET_DIR3%...
    xcopy /E /Y %SOURCE_DIR%\%%F %TARGET_DIR3%\%%F
)

echo Kopiervorgang abgeschlossen!
pause
