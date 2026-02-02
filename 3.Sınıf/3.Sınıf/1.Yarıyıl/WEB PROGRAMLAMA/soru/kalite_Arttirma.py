import cv2
import numpy as np
from pdf2image import convert_from_path
from PIL import Image

# PDF dosyasını al ve resimlere dönüştür
def pdf_to_images(pdf_path, dpi=300):
    images = convert_from_path(pdf_path, dpi=dpi)
    return images

# Resmin kalitesini artır (örneğin: keskinleştirme, çözünürlük artırma)
def enhance_image(image):
    # OpenCV ile görüntüyü işleme
    image = np.array(image)
    
    # Boyut artırma (örneğin: 2x büyütme)
    upscale_factor = 2
    height, width = image.shape[:2]
    enlarged_image = cv2.resize(image, (width * upscale_factor, height * upscale_factor), interpolation=cv2.INTER_CUBIC)
    
    # Keskinleştirme filtresi
    kernel = np.array([[0, -1, 0],
                       [-1, 5, -1],
                       [0, -1, 0]])
    sharpened_image = cv2.filter2D(enlarged_image, -1, kernel)
    
    return sharpened_image

# İşlenmiş görüntüleri kaydet
def save_images(images, output_dir):
    for idx, image in enumerate(images):
        output_path = f"{output_dir}/enhanced_image_{idx + 1}.png"
        Image.fromarray(image).save(output_path)
        print(f"{output_path} kaydedildi.")

# PDF işle
def process_pdf(pdf_path, output_dir):
    # PDF'den resimleri çıkar
    images = pdf_to_images(pdf_path)
    
    enhanced_images = []
    for image in images:
        # Her görüntüyü geliştir
        enhanced_image = enhance_image(image)
        enhanced_images.append(enhanced_image)
    
    # Görüntüleri kaydet
    save_images(enhanced_images, output_dir)

# Kullanım
pdf_path = "dosyanız.pdf"  # PDF dosyasının yolunu buraya yazın
output_dir = "output"  # Çıktılar için bir klasör adı
process_pdf(pdf_path, output_dir)
