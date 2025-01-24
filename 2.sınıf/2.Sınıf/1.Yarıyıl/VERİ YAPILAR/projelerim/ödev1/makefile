all: derle calistir

derle:
	g++ -c -I "./include/" ./src/Main.cpp -o ./lib/Main.o
	g++ -c -I "./include/" ./src/Gen.cpp -o ./lib/Gen.o 
	g++ -c -I "./include/" ./src/Kromozom.cpp -o ./lib/Kromozom.o 
	g++ -c -I "./include/" ./src/Dna.cpp -o ./lib/Dna.o 
calistir:
	g++    ./lib/Gen.o ./lib/Main.o   ./lib/Kromozom.o  ./lib/Dna.o    -o ./bin/program  
	./bin/program
