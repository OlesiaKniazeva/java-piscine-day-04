############ INSTRUCTIONS ############

##  You can start app by enter command ./README.txt

###  Enter symbols to print images

WHITE_CHAR=.
BLACK_CHAR=O

# ---------------------------------------------------------------------------------- #

# delete old compilation files
rm -rf target

# create new empty directory named target
mkdir -p target

# set destination directory for .class files
javac -d ./target src/java/edu/school21/printer/*/*.java

# copy resources to target
cp -R src/resources target/

# create executable .jav archive
jar --create --manifest=src/manifest.txt --file=target/images-to-chars-printer.jar  -C target .

# change access to jar file
chmod 777 target/images-to-chars-printer.jar

# start program
java -jar target/images-to-chars-printer.jar ${BLACK_CHAR} ${WHITE_CHAR}

