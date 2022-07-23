############ INSTRUCTIONS ############

##  You can start app by enter command ./README.txt

###  Enter symbols to print images and path to image

WHITE_CHAR=.
BLACK_CHAR=Y
IMAGE_PATH=/home/myael/java-piscine/piscine-day-04/ex00/ImageToChar/heart.bmp

# ---------------------------------------------------------------------------------- #

# delete old compilation files
rm -rf target

# create new empty directory named target
mkdir -p target

# set destination directory for .class files
javac -d ./target src/java/edu/school21/printer/*/*.java

# start program
java -cp target edu.school21.printer.app.Main ${BLACK_CHAR} ${WHITE_CHAR} ${IMAGE_PATH}

