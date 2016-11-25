@echo off
set /p iofile=输入文件：
set /p outfile=输出文件：
native2ascii -encoding utf-8  %iofile%  %outfile%