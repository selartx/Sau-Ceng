/**
* @file B231210019 Veri Yapıları Ödev 1
* @description Gen sınıfının tanımlanması 
*@course 1/A
* @assignment 1
* @date 26/11/2024
* @author Selva Artunç selva.artunc@ogr.sakarya.edu.tr
*/

#ifndef GEN_HPP
#define GEN_HPP
using namespace std;
class Gen {
public:
    char gen;
    Gen* next;
    Gen* prev;
    Gen(char gen);
	~Gen();
};

#endif