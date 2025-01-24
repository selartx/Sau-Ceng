/**
* @file B231210019 Veri Yapıları Ödev 1
* @description Main cpp* 
*@course 1/A
* @assignment 1
* @date 26/11/2024
* @author Selva Artunç selva.artunc@ogr.sakarya.edu.tr
*/
#include "Dna.hpp"
#include <iostream>
#include <fstream>
using namespace std;


int main()
{
    Dna dna;
    dna.DosyadanYukle("Dna.txt");

    char choice;

    while (true)
    {
        dna.Secimler();
       
        cout << "\nSeciminiz: ";
        cin >> choice;

        
        if (choice == 'X' || choice == 'x')
        {
            cout << "Programdan çıkılıyor.\n";
            break; 
        }

        
        switch (choice)
        {
        case 'C':
        {
            int index1, index2;
            cout << "Çaprazlama için iki kromozom indeksi girin: ";
            cin >> index1 >> index2;
            dna.Caprazlama(index1, index2);
            cout << "Çaprazlama işlemi tamamlandı.\n";
            break;
        }

        case 'M':
        {
            int chromosomeIndex, geneIndex;
            cout << "Mutasyon için kromozom ve gen indekslerini girin: ";
            cin >> chromosomeIndex >> geneIndex;
            dna.Mutasyon(chromosomeIndex, geneIndex);
            cout << "Mutasyon işlemi tamamlandı.\n";
            break;
        }

        case 'O':
        {
            cout << "Otomatik işlemler dosyasından komutlar uygulanıyor...\n";
            dna.OtomatikIslemler("Islemler.txt");
            break;
        }

        case 'E':
        {   dna.Goster();
            dna.ekranaYaz();
        }
       
        default:
        {
            cout << "Geçersiz seçim! Lütfen tekrar deneyin.\n";
            break;
        }
        }
    }

    return 0;
}
