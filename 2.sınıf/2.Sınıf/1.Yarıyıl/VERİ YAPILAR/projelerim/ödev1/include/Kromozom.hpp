/**
* @file B231210019 Veri Yapıları Ödev 1
* @description Kromozom sınıfının tanımlanması 
*@course 1/A
* @assignment 1
* @date 26/11/2024
* @author Selva Artunç selva.artunc@ogr.sakarya.edu.tr
*/
#ifndef KROMOZOM_HPP
#define KROMOZOM_HPP
#include  <iostream>
#include "Gen.hpp"
using namespace std;
class Kromozom {

public:
    Gen* head;       
    Gen* tail;       

    Kromozom();                  
    ~Kromozom();                    
    void GenEkle(char gen);          // Geni bağlı listeye ekler
    void Goster() const;             // Kromozomu ekrana yazdırır
    void MutasyonGen(int position);    // Belirtilen pozisyondaki geni değiştirir
    void Kombinasyon(Kromozom* hedef,int orta1,int orta2); // Tüm genleri başka bir kromozoma ekler
    int Lenght();
};

#endif