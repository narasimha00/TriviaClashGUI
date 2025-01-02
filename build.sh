#!/bin/sh

DIRS_PATH='out/jar/'
JAR_FILE_OUTPUT_PATH='app/build/libs/'

# Make a directory to store jar file
create_dirs() {
    if [ ! -d "$DIRS_PATH" ]; then 
        echo " Creating dirs at $DIRS_PATH ..."
        return $(mkdir -p "$DIRS_PATH"; echo $?)
    else 
        return 0
    fi
}


# Build the jar file 
build_jar() {
    echo ""
    echo " Generating the .jar file at $JAR_FILE_OUTPUT_PATH ..."
    ./gradlew assemble "$@"
    return $(echo $?)
}

# Copy the jar file to the created folder
copy_jar() {
    echo ""
    echo " Copying the jar file to $DIRS_PATH ..."
    return $(cp "$JAR_FILE_OUTPUT_PATH/app-all.jar" "$DIRS_PATH/TriviaClash-gui.jar"; echo $?)
}

run() {
    echo ""
    echo "STARTING RUN OPERATION..."
    sh -c "java -jar out/jar/TriviaClash-gui.jar"
}

help() {
    echo ""
    echo "The following are the available flags for this script"
    echo ""
    echo "-h, --help => Display this help message and exit."
    echo "-r, --run => Run after the build succeeds."
    echo ""
}

build() {
    echo ""
    echo "STARTING BUILD !!"
    create_dirs && build_jar && copy_jar
    echo ""
    if [ ! $(echo $?) ]; then
        echo " Jar couldn't be generated !! "
        exit
    else
        echo " The jar file can be found in $DIRS_PATH "
    fi
}

# check the arguments for more options 
case $@ in 
    "-h" | "--help")
        help
        exit
        ;;
    "-r" | "--run")
        build && run
        ;;
    *)
        build 
        ;;
esac

