/**
* @file B231210019 Veri Yapıları Ödev 1
* @description Dna  sınıfının methodlarının yazılması* 
*@course 1/A
* @assignment 1
* @date 26/11/2024
* @author Selva Artunç selva.artunc@ogr.sakarya.edu.tr
*/
#include "Dna.hpp"
#include "Kromozom.hpp"
#include <iostream>
#include <fstream>

Dna::Dna() : head(nullptr), tail(nullptr), size(0) {}

Dna::~Dna() {
    DnaDugum* current = head;
    while (current != nullptr) {
        DnaDugum* toDelete = current;
        delete current->kromozom;
        current = current->next;
        delete toDelete;
    }
}

void Dna::DosyadanYukle(const char* filename) {
    ifstream file(filename);
    if (!file.is_open()) {
        cerr << "Dosya açılamadı: " << filename << endl;
        return;
    }

    Kromozom* kromozom = nullptr;
    char c;

    while (file.get(c)) {
        if (c == '\n') {
            if (kromozom) {
                KromozomEkle(kromozom); 
                kromozom = nullptr;
            }
        } else if (c != ' ') {
            if (!kromozom) {
                kromozom = new Kromozom();
            }
            kromozom->GenEkle(c);
        }
    }

    if (kromozom) {
        KromozomEkle(kromozom);
    }

    file.close();
}

void Dna::KromozomEkle(Kromozom* kromozom) {
    DnaDugum* yeni = new DnaDugum(kromozom);
    if (head == nullptr) {
        head = tail = yeni;
    } else {
        tail->next = yeni;
        tail = yeni;
    }
    size++;
}

Kromozom* Dna::Kromozomgetir(int index) const {
    if (index < 0 || index >= size) {
        cerr << "Geçersiz indeks!" << endl;
        return nullptr;
    }

    DnaDugum* current = head;
    int count = 0;

    while (current != nullptr) {
        if (count == index) {
            return current->kromozom;
        }
        current = current->next;
        count++;
    }

    return nullptr;
}

void Dna::Caprazlama(int index1, int index2) {
    Kromozom* krom1 = Kromozomgetir(index1);
    Kromozom* krom2 = Kromozomgetir(index2);

    if (krom1 == nullptr || krom2 == nullptr) {
        cerr << "Çaprazlama için geçersiz indeksler!" << endl;
        return;
    }

    int uzunluk1 = krom1->Lenght();
    int uzunluk2 = krom2->Lenght();

    int orta1 = uzunluk1 / 2;
    int orta2 = uzunluk2 / 2; 

    Kromozom* newkrom1 = new Kromozom();
    Kromozom* newkrom2 = new Kromozom();

    
    if (uzunluk1 % 2 == 0) { 
        krom1->Kombinasyon(newkrom1, 0, orta1);          
        krom1->Kombinasyon(newkrom2, orta1+1, uzunluk1);   
    } else { 
        krom1->Kombinasyon(newkrom1, 0, orta1);          
        krom1->Kombinasyon(newkrom2, orta1 + 1, uzunluk1); 
    }

    
    if (uzunluk2 % 2 == 0) { 
        krom2->Kombinasyon(newkrom1, orta2+1, uzunluk2);  
        krom2->Kombinasyon(newkrom2, 0, orta2-1);         
    } else { 
        krom2->Kombinasyon(newkrom1, orta2 + 1, uzunluk2); 
        krom2->Kombinasyon(newkrom2, 0, orta2);          
    }

    KromozomEkle(newkrom1);
    KromozomEkle(newkrom2);

    cout << "New Kromozom 1: ";
    newkrom1->Goster();
    cout << "New Kromozom 2: ";
    newkrom2->Goster();
}



void Dna::Mutasyon(int KromozomIndex, int genIndex) {
    Kromozom* krom = Kromozomgetir(KromozomIndex);
    if (krom == nullptr) {
        cerr << "Mutasyon için geçersiz kromozom indeksi!" << endl;
        return;
    }

    krom->MutasyonGen(genIndex);
    
}

void Dna::OtomatikIslemler(const char* filename) {
    ifstream file(filename);
    if (!file.is_open()) {
        cerr << "OtomatikIslemler.txt dosyası açılamadı: " << filename << endl;
        return;
    }

    char c;
    while (file.get(c)) {
        if (c == 'C' || c == 'M') {
            int index1 = 0, index2 = 0;
            char temp;

            while (file.get(temp) && isdigit(temp)) {
                index1 = index1 * 10 + (temp - '0');
            }
//ASCII koduna göre yazdım
            while (file.get(temp) && isdigit(temp)) {
                index2 = index2 * 10 + (temp - '0');
            }

            if (c == 'C') {
                Caprazlama(index1, index2);
            } else if (c == 'M') {
                Mutasyon(index1, index2);
            }
        }
    }

    file.close();
}



void Dna::Goster() const {
    DnaDugum* current = head;
    int index = 0;

    while (current != nullptr) {
        cout << " ";
        current->kromozom->Goster();
        current = current->next;
        index++;
    }
}
void Dna::ekranaYaz(){
    DnaDugum* currentDna = head; 

    while (currentDna != nullptr) {
        Kromozom* krom = currentDna->kromozom; 
        Gen* currentgen = krom->tail; 
        char firstgen = krom->head->gen;  
        char selectedgen = firstgen;  

        while (currentgen != nullptr) {
            if (currentgen->gen < firstgen) {
                selectedgen = currentgen->gen;  
                break;  
            }
            currentgen = currentgen->prev;  
        }

        cout << selectedgen << " "; 

        currentDna = currentDna->next; 
    }

    cout << endl; 
}

void Dna::Secimler() {
    cout << "--------------------------------------------------\n";
    cout << "C Çaprazlama \n";
    cout << "M Mutasyon \n";
    cout << "O Otomatik İşlemler \n";
    cout << "E Ekrana Yaz \n";
    cout << "X Çıkış \n";
    cout << "--------------------------------------------------\n";
}
