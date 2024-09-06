# CompressPdf
Module with action that lets you compress a pdf file by compressing the images in said file.
The module is created in Mendix version 10.3.1



## How to use

3 parameters are used:
- A .Pdf file
- CompressionLevel: this integer determines how much the images will be compressed. The resolution will be divided by the entered number. If no number is entered the default of 2 will be used.
- Minimum file size: This integer (in KB) determines the file size above which images will be compressed. A default value of 500 KB is used if no value is entered



## Dependencies
This module is dependant on:
pdfbox-2.0.31
commons-logging-1.3.3

Alternatively the CommunityCommons module can be downloaded from the marketplace. This also suffices.

on the community commons module. Specifially it requires pdfbox. 




## Demo
A demo project can be found at https://compresspdf-sandbox.mxapps.io/

## Contribute
If you want to contribute to this module, put in a request or pull request via github (https://github.com/WebFlight/SecurePdf).

