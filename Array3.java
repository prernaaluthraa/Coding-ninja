import sys
from datetime import datetime
sys.path.insert(0, '/application/RPA/COMMON/STANDARD_OCR/SRC/')
import StandardFormExtract_page as sd
import os
import pathlib
import bs4
from pdf2image import convert_from_path
from pytesseract import pytesseract
from PyPDF2 import PdfWriter, PdfReader

print("Starting the process at",datetime.now())
#Full file path, document type (urla, cd etc). File format (PDF or TIFF)
# ********************* Pre- Proceessing - Page Removing code **************************** #

# def preProcessing(pdfFileName):
#     PDF = pdfFileName
#     print(PDF)
#     hocrfilename=pathlib.Path(PDF).stem
#     print(hocrfilename)
#     Tiffilename= hocrfilename + ".tiff"
#     print(Tiffilename)




#     # Tiffilename="Appraisal (2-4 Units).tiff"
#     # PDF="/application/RPA/COMMON/STANDARD_OCR/TEMP_DEV/Gunveer/Appraisal (2-4 Units).pdf"
    
#     pages = convert_from_path(PDF,first_page=1,last_page=7)

#     #Get first 7 pages
#     try:
#         pages[0].save(Tiffilename, format="tiff", append_images=[pages[1],pages[2],pages[3],pages[4],pages[5],pages[6]], save_all=True, duration=500, loop=0)
#     except:
#         pages[0].save(Tiffilename)
#     custom_oem_psm_config = r'-c tessedit_do_invert=0 --oem 1 --psm 6'

#     pytesseract.run_tesseract(Tiffilename, hocrfilename, lang=None, extension='hocr',config=custom_oem_psm_config)
#     xml_input = open(hocrfilename+".hocr","r",encoding="utf-8")

#     ######## Parsing xml data usign Beautiful soup and passing only OCR lines for extraction
#     soup = bs4.BeautifulSoup(xml_input,'lxml')
#     ocr_lines = soup.findAll("span", {"class": "ocr_line"})
#     xml_input.close()
#     propAppripage=1
#     for line in ocr_lines:
#         line_text= line.text.replace("\n"," ").strip().replace('  ',' ')
#         if 'Small Residential Income Property Appraisal Report' in line_text:
#             propAppripage = str(line.parent.parent.parent['id']).split("_")[1]
#             print(propAppripage)
#             break

#     os.remove(hocrfilename+".hocr")
#     os.remove(hocrfilename+".tiff")
#     infile = PdfReader(PDF)
#     output = PdfWriter()
#     for i in range(len(infile.pages)):
#         if i<int(propAppripage) - 1:
#             pass
#         else:
#             p=infile.pages[i]
#             output.add_page(p)
#     # with open(hocrfilename+'_updated.pdf', 'wb') as f:
#     #     output.write(f)

#     newpdf = '/application/RPA/COMMON/STANDARD_OCR/TEMP_DEV/Gunveer/'+ hocrfilename + '_updated.pdf'
#     print('outputfile is '+newpdf)

#     with open(newpdf, 'wb') as f:
#         output.write(f)

#     return newpdf
    
    


# # ************************ Farmework Func code to extract values with bounding box *********************************#
# # New file name should be provide as 1st argument in Func
# newpdf = preProcessing('/application/RPA/COMMON/STANDARD_OCR/TEMP_DEV/Gunveer/Appraisal (2-4 Units).pdf')
form_dict= sd.form_extract_initiate('/application/RPA/COMMON/STANDARD_OCR/TEMP_DEV/Gunveer/Appraisal (2-4 Units).pdf', "TEMP_PROP_APPRAISAL", "PDF")
print(form_dict)
print("Execution Complete at",datetime.now())

# ********************* Post - Processing (RegEx or String Manuplation)****************************
form_dict['Company Address'][0] = form_dict['Company Address'][0].replace("Company Address","").strip()
print(form_dict)


form_dict['APPRAISED VALUE'][0] = form_dict['APPRAISED VALUE'][0].replace("APPRAISED VALUE","").strip()
print(form_dict)


form_dict['Appraisal_TYPE'][0] = form_dict['Appraisal_TYPE'][1].replace("Appraisal_TYPE","").strip()
print(form_dict)
