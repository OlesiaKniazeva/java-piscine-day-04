############ INSTRUCTIONS ############

##  You can start app by enter command ./README.txt

FIRST_COLOR=BLUE
SECOND_COLOR=CYAN

# ---------------------------------------------------------------------------------- #

# cleaning
rm -rf target lib

# create directories
mkdir -p target lib

# download external lib
wget -cq -P lib https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
wget -cq -P lib https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar

# unpack of libraries and move their .class files to target
jar --extract --file=lib/jcommander-1.82.jar
jar --extract --file=lib/JCDP-4.0.2.jar

mv com target
rm -rf META-INF

# set destination directory for .class files
javac -d target -cp lib/jcommander-1.82.jar:lib/JCDP-4.0.2.jar src/java/edu/school21/printer/*/*.java

# copy resources to target
cp -R src/resources target/

# create executable .jav archive
jar --create --manifest=src/manifest.txt --file=target/images-to-chars-printer.jar  -C target .

# change access to jar file
chmod 777 target/images-to-chars-printer.jar

# start program
#java -jar target/images-to-chars-printer.jar --white=${FIRST_COLOR} --black=${SECOND_COLOR}
java -jar target/images-to-chars-printer.jar --white=${FIRST_COLOR} --black=${SECOND_COLOR}

