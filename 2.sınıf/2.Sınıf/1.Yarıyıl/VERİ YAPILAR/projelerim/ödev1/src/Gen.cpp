/**
* @file B231210019 Veri Yapıları Ödev 1
* @description Gen sınıfının methodlarının yazılması* 
*@course 1/A
* @assignment 1
* @date 26/11/2024
* @author Selva Artunç selva.artunc@ogr.sakarya.edu.tr
**/
#include "Gen.hpp"

Gen::Gen(char gen) {
    this->gen = gen;
    this->next = nullptr; 
    this->prev=nullptr;
}
Gen::~Gen() {
    next = nullptr;
    prev = nullptr;
}