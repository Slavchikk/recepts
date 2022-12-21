package com.example.recepts;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;




public class ViewRecipe extends AppCompatActivity {
    Bundle arg;
    Recipe recipe;
    TextView fullN, nameN,calorys,times;
    TextView fullText;
    ImageView imageView;
    final Context context = this;
    String itog;
    String itogRost;
    String itogVozr;
    float ves;
    float rost;
    float vozr;float call;
    String results;
    private TextView final_text;
    Bitmap bitmap=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        fullText = findViewById(R.id.txtLog);
        arg = getIntent().getExtras();
        recipe = arg.getParcelable(Recipe.class.getSimpleName());
        fullN = findViewById(R.id.txtFull);
        calorys = findViewById(R.id.txtCalorys);
        times = findViewById(R.id.txtTimes);
        nameN = findViewById(R.id.txtName);
        imageView = findViewById(R.id.imageView3);

        fullN.setText(recipe.getFullRecipe());
        nameN.setText(recipe.getNameRecipe());
        calorys.setText(recipe.getCalory());
        times.setText(recipe.getTimeGot());
        DecodeImage decodeImage = new DecodeImage(ViewRecipe.this);
        Bitmap userImage = decodeImage.getUserImage(recipe.getImage());
        imageView.setImageBitmap(userImage);
        if(!recipe.getImage().equals("null")){
            bitmap = userImage;
        }
        String currentString = recipe.getNameRecipe();
        String[] separated = currentString.split(" ");
        String s = separated[0];

        String currentStringV = calorys.getText().toString();
        String[] separatedV = currentStringV.split(" ");
        String sV = separatedV[0];
        call = Float.parseFloat(sV);
        switch (s)
        {

            case "горбуша":
                fullText.setText("Время приготовления: 40 минут\n" +
                        "Белки\tЖиры\tУглеводы\n" +
                        "21 г\t7 г\t>0 г\n" +
                        "Ингриденты: горбуша\n" +
                        "горбушу отварить. Для вкуса добавить лавровый лист, специи, зелень. Без соли");
                break;
            case "Курица":
                fullText.setText("Время приготовления: 15 минут\\\" +\n" +
                        "Белки\tЖиры\tУглеводы\n" +
                        "19.8 г\t16.6 г\t>2.6 г \n" +
                        "Ингриденты: 4 куриных филе\n" +
                        "1 яйцо\n" +
                        "4 ст.л. оливкового масла\n" +
                        "1 ст. миндаля\n" +
                        "2 зубчика чеснока\n" +
                        "специи\n" +
                        "соль \n" +
                        " Куриные филе промыть, обсушить. Накрыть плёнкой и отбить кухонным молотком.\n" +
                        " Измельчить миндаль и чеснок с маслом, солью и специями.\n" +
                        " Противень застелить фольгой, смазать маслом. Разогреть духовку.\n" +
                        " Разбить в миску яйцо, окунуть туда филе, обсыпать миндальной панировкой и выложить на противень.\n" +
                        " Запекать курицу в миндальной панировке при 200 градусах 20 минут. Приятного аппетита!\"");
                break;

            case "Пастрома":
                fullText.setText("Время приготовления: 25 минут\\\" +\n" +
                        "Белки\tЖиры\tУглеводы\n" +
                        "19.3 г\t2.9 г\t>1.8 " +
                        "Ингриденты: куриная грудка, без кожи, соль поваренная пищевая, чеснок, укроп и другие пряные травы, петрушка, масло подсолнечное" +
                        "1. Растворить соль в воде и замочить мясо в полученном рассоле на ночь.\n" +
                        "\n" +
                        "2. Чеснок и зелень измельчить, смешать с растительным маслом. Обмазать филе полученной смесью.\n" +
                        "\n" +
                        "3. Поместить в разогретую до 250 градусов духовку на 15 минут.\n" +
                        "\n" +
                        "4. Выключить духовку и оставить пастрому в печи до полного остывания (около 2х часов).") ;
                break;
            case "Картофельные":
                fullText.setText("Время приготовления: 50 минут \n" +
                        "Белки\tЖиры\tУглеводы\n" +
                        "4.8 г\t8.8 г\t>20.9 г" +
                        "Ингриденты: 200 г копчёного мяса (грудинка или другое)\n" +
                        "1 кг картофеля (заранее отваренного в кожуре)\n" +
                        "200 г цельнозерновой муки\n" +
                        "4 ст.л. манки\n" +
                        "2 луковицы\n" +
                        "2 яйца\n" +
                        "топлёное масло или сало для жарки\n" +
                        "немного картофельного крахмала\n" +
                        "перец молотый\n" +
                        "соль\n" +
                        "Сваренный и остуженный картофель очистить от кожуры, пропустить через мясорубку.\n" +
                        "Добавить манку, муку, яйца и соль, замесить эластичное тесто.\n" +
                        "Лук мелко нарезать, обжарить в масле, добавить нарезанное копчёное мясо, обжарить слегка всё вместе. По вкусу посолить и поперчить.\n" +
                        "Из кусочков теста сформировать лепёшки, наполнить начинкой из мяса с луком, защипнуть или сделать шарики. Подобным образом слепить все кнедлики и, если липоквато, обвалять в крахмале.\n" +
                        "Кнедлики варить в кипящей воде 15 минут, либо можно сварить в пароварке. Подавать с растопленным маслом, сметаной, квашеной капустой жареным лучком, если от начинки остался. Приятного аппетита!");
                break;
            case "Грибной":
                fullText.setText("Время приготовления: 20 минут\\\" +\n" +
                        "Белки\tЖиры\tУглеводы\n" +
                        "0.7 г\t1.1 г\t>3.5 г" +
                        "Потребуется:\n" +
                        "\n" +
                        "250 г замороженных грибов - белых или других,\n" +
                        "\n" +
                        "3 шт. картофеля,\n" +
                        "\n" +
                        "100 г перловки,\n" +
                        "\n" +
                        "1 морковь,\n" +
                        "\n" +
                        "1 луковица,\n" +
                        "\n" +
                        "2 соленых огурца,\n" +
                        "\n" +
                        "3 л воды,\n" +
                        "\n" +
                        "0,5 л рассола,\n" +
                        "\n" +
                        "40 г топленого масла,\n" +
                        "\n" +
                        "лавровый лист,\n" +
                        "\n" +
                        "соль,\n" +
                        "\n" +
                        "перец" +
                        "1. Грибы обдать кипятком, и, если слишком крупные, порезать на куски поменьше. Залить 2,5 л горячей воды и варить 40 минут под крышкой.\n" +
                        "\n" +
                        "2. Перловку сварить отдельно, промыть, так бульон супа будет прозрачней.\n" +
                        "\n" +
                        "3. Лук и морковку почистить и обжарить в топленом масле.\n" +
                        "\n" +
                        "4. Картошку почистить, порезать и добавить к грибам, варить 10 минут.\n" +
                        "\n" +
                        "5. В суп положить перловку, мелко нарезанные огурцы, поджарку, влить рассол, добавить специи и лавровый лист.\n" +
                        "\n" +
                        "Готовый рассольник подавать горячим, со свежей зеленью, со сметаной. Приятного аппетита!");
                break;
            default:fullText.setText("fnotfound");
        }
        //separated[1];


    }

    private final ActivityResultLauncher<Intent> pickImg = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            if (result.getData() != null) {
                Uri uri = result.getData().getData();
                try {
                    InputStream is = getContentResolver().openInputStream(uri);
                    bitmap = BitmapFactory.decodeStream(is);
                    imageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                    Log.e(e.toString(), e.getMessage());
                }
            }
        }
    });
    public void AddPhoto(View v){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        pickImg.launch(intent);
    }

    public void calcWeight(View v)
    {


        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompt, null);

        //Создаем AlertDialog
        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

        //Настраиваем prompt.xml для нашего AlertDialog:
        mDialogBuilder.setView(promptsView);

        //Настраиваем отображение поля для ввода текста в открытом диалоге:
        final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);
        final EditText userRost = (EditText) promptsView.findViewById(R.id.input_text1);
        final EditText userVozr = (EditText) promptsView.findViewById(R.id.input_text2);
        //Настраиваем сообщение в диалоговом окне:
        mDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                //Вводим текст и отображаем в строке ввода на основном экране:

                                //final_text.setText(userInput.getText());
                                itog =  userInput.getText().toString();
                                itogRost= userRost.getText().toString();
                                itogVozr=userVozr.getText().toString();

                                try{
                                    ves = Integer.parseInt(itog);
                                    vozr = Integer.parseInt(itogVozr);
                                    rost = Integer.parseInt(itogRost);
                                }
                                catch (Exception e)
                                {
                                    ShowError("Неверно введено числовое значения какого-либо поля");
                                }
                                float rostC = rost/100;
                                rostC = rostC * rostC;

                                float indtel = ves/rostC;
                                String result = String.format("%.2f",indtel);
                                if(indtel < 17.5) results = "Ваш индекс массы тела: "+ result + "\nСостояние: анорексия";
                                else if (17.5 < indtel && indtel < 18.5) {results = "Ваш индекс массы тела: "+ result + "\nСостояние: Дефицит массы тела";}
                                else if (18.5 < indtel && indtel < 25.9) {results = "Ваш индекс массы тела: "+ result + "\nСостояние: Нормальное состояние";}
                                else if (18.5 < indtel && indtel < 25.9) {results = "Ваш индекс массы тела: "+ result + "\nСостояние:  Избыточная масса тела";}
                                else if (25.9 < indtel && indtel < 27.9) {results = "Ваш индекс массы тела: "+ result + "\nСостояние:  Ожирение первой степени";}
                                else if (27.9 < indtel && indtel < 30.9) {results = "Ваш индекс массы тела: "+ result + "\nСостояние:  Ожирение второй степени";}
                                else if (30.9 < indtel && indtel < 35.9) {results = "Ваш индекс массы тела: "+ result + "\nСостояние:  Ожирение третьей степени";}
                                else if (35.9 < indtel ) {results = "Ваш индекс массы тела: "+ result + "\nСостояние:  Ожирение четвертой степени";}
                                else{ results = "ошибка";}

                                // Для мужчин: (10 х вес в кг) + (6,25 х рост в см) – (5 х возраст в г) + 5.
                                float grammfood = (float) ((((10 * ves) + (6.25 * rost) - (5*vozr)) / call )/3) * 100;
                                result = String.format("%.2f",grammfood);
                                results += "\nКоличество граммов еды на один прием: " +  result;
                                ShowInfo(results);



                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        //Создаем AlertDialog:
        AlertDialog alertDialog = mDialogBuilder.create();

        //и отображаем его:
        alertDialog.show();



    }
    public void ShowInfo(String ret)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Результат")
                .setMessage(ret)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void ShowError(String ret)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Ошибка при вводе")
                .setMessage(ret)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}