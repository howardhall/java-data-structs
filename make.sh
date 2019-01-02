#!/bin/bash
function clean (){
  rm -rf "build/"
}
function buildtest (){
  mkdir "build"
  javac -d build src/test.java -cp .
}
function build (){
  mkdir "build"
  javac -d build $(find -name "*.java") -cp .
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
function document (){
  mkdir docs
  javadoc -sourcepath .  -d docs -subpackages .
}
function commit (){
  git add .
  echo -n "Enter commit message: "
  read msg
  git commit -m "$msg"
  git push
}
while getopts cbtrdg opt; do
  case $opt in
    c)
      echo "clean"
      clean
      ;;
    t)
      echo "build test"
      clean
      buildtest
      run "src/test"
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
    d)
      echo "Updating documentation"
      document
      ;;
    g)
      echo "Git commit"
      commit
      ;;
  esac
done
