#!/bin/bash
function clean (){
  rm -rf "build/"
}
function build (){
  mkdir "build"
  javac -d build src/*.java
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
function build2 (){
  mkdir "build"
  dirs=( "util" "list" "map" "priorityqueue" "queue" "set" )
  for i in "${dirs[@]}"
  do
    mkdir "build/$i"
    javac -d build/$i src/$i/*.java
  done
  javac -d build src/*.java
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
      build2
      ;;
    r)
      echo "run"
      run $2
      ;;
  esac
done
