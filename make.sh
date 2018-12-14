#!/bin/bash
function clean (){
  rm -rf "build/"
}
function build (){
  mkdir "build"
  javac -d build src/test.java -cp .
}
function run (){
  if [ -z "$1" ]; then
    target="src/test"
  else
    target="$1"
  fi
  cd build
  java $target
}
while getopts cbr opt; do
  case $opt in
    c)
      echo "clean"
      clean
      ;;
    b)
      echo "build"
      clean
      build
      ;;
    r)
      echo "run"
      run $2
      ;;
  esac
done
