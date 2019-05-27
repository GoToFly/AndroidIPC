// IBookAidlInterface.aidl
package com.horry.myapplication.aidl;
import com.horry.myapplication.aidl.Book;
// Declare any non-default types here with import statements

interface IBookAidlInterface {
    void addBook(inout Book book);//注意：如果不加tag(in,inout,out)就会报Process 'command '/Users/wuhorry/Library/Android/sdk/build-tools/28.0.3/aidl'' finished with non-zero exit value 1
    Book getBook();
}
