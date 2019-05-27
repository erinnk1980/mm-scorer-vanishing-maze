#!/bin/sh
rm -r ./bin
mkdir bin

find . -name "VanishingMazeVis.java" > sources.txt
javac -d ./bin @sources.txt

jar -cvfm tester.jar manifest.mf -C ./bin .