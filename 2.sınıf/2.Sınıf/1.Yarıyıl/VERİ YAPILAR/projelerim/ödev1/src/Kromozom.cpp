/**
* @file B231210019 Veri Yapıları Ödev 1
* @description Kromozom sınıfının methodlarının yazılması* 
*@course 1/A
* @assignment 1
* @date 26/11/2024
* @author Selva Artunç selva.artunc@ogr.sakarya.edu.tr
*/
#include "Kromozom.hpp"
#include <iostream>

Kromozom::Kromozom() {
    head = nullptr;
    tail = nullptr;
}

Kromozom::~Kromozom() {
    Gen* current = head;
    while (current != nullptr) {
        Gen* toDelete = current;
        current = current->next;
        delete toDelete;
    }
}
void Kromozom::GenEkle(char gen) {
    Gen* newGen = new Gen(gen);
    if (head == nullptr) {
        head = tail = newGen;
    } else {
        tail->next = newGen;
        newGen->prev = tail;  
        tail = newGen;
    }
}
void Kromozom::MutasyonGen(int position) {
    Gen* current = head;
    int index = 0;

    while (current != nullptr && index < position) {
        current = current->next;
        index++;
    }

    if (current != nullptr) {
        current->gen = 'X'; 
        Goster();
    } else {
        cerr << "Mutasyon için geçersiz pozisyon: " << position << endl;
    }
}

void Kromozom::Goster() const {
    Gen* current = head;
    while (current != nullptr) {
        cout << current->gen << " ";
        current = current->next;
    }
    cout << endl;
}
void Kromozom::Kombinasyon(Kromozom* target, int start, int end) {
    Gen* current = head;
    int index = 0;

    while (current != nullptr) {
        if (index >= start && index <= end) {
            target->GenEkle(current->gen);
        }
        current = current->next;
        index++;
    }
}

int Kromozom::Lenght(){
    Gen* itr=head;
    int lenght=0;
    while(itr->next!=nullptr){
        lenght++;
        itr=itr->next;
    }
    return lenght;
}