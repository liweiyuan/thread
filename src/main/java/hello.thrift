namespace java com.wade.tingyun.service.demo
service Hello{
   string helloString(1:string para)
   i32 helloInt(1:i32 para)
   bool helloBoolean(1:bool para)
   void helloWorld()
   string helloNull()
}