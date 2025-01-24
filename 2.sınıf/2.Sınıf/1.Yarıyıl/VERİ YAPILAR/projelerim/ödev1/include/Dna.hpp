/**
* @file B231210019 Veri Yapıları Ödev 1
* @description Dna sınıfının tanımlanması 
* @course 1/A
* @assignment A
* @date 26/11/2024
* @author Selva Artunç selva.artunc@ogr.sakarya.edu.tr
*/

#ifndef DNA_HPP
#define DNA_HPP
#include<iostream>
#include "Kromozom.hpp"
using namespace std;
class Dna {
private:
    struct DnaDugum {
        Kromozom* kromozom;
        DnaDugum* next;

        DnaDugum(Kromozom* krom) : kromozom(krom), next(nullptr) {}
    };

    DnaDugum* head;
    DnaDugum* tail;
    int size;

public:
    Dna();
    ~Dna();
    void DosyadanYukle(const char* filename );               // Dosyadan kromozom yükler
    void KromozomEkle(Kromozom* Kromozom);            // Yeni kromozom ekler
    Kromozom* Kromozomgetir(int index) const;            // Belirtilen indeksteki kromozomu döndürür
    void Caprazlama(int index1, int index2);                // Çaprazlama işlemi
    void Mutasyon(int KromozomIndex, int geneIndex);       // Mutasyon işlemi
    void Goster() const;                                  // Tüm kromozomları ekrana yazdırır
    void OtomatikIslemler(const char* filename);   // Otomatik işlemleri uygular
    void ekranaYaz();
    void Secimler();
};

#endif
