import org.jetbrains.annotations.NotNull;
import retrofitModel.entity.InfoData;
import retrofitModel.entity.Product;
import retrofitModel.entity.StorageOperation;
import retrofitModel.repo.TalosRepo;

import java.io.IOException;
import java.util.List;

public class ClientController {
    private static ClientController instance;
    private TalosRepo talosRepo;
    private ClientController() {
        talosRepo = TalosRepo.getSingleton();
    }
    public static synchronized ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public synchronized ElementScaffold[] getBalance () {
        ElementScaffold [] elementsBalance = new ElementScaffold[7];
        List<InfoData> infoDataList;
        List<Product> products;
        try {
            infoDataList = TalosRepo.getSingleton().getApi().loadInfoData().execute().body();
            products = TalosRepo.getSingleton().getApi().loadProducts().execute().body();
            for (int i = 0; i < infoDataList.size(); i++) {
                String name = infoDataList.get(i).getName();
                double buyingPrice = infoDataList.get(i).getPriceRin();
                double weight = infoDataList.get(i).getWeight();
                if (name.equals("Рама с лестницей (42х1,5)")) {
                    elementsBalance[0] = new ElementScaffold(name, weight, buyingPrice);
                }
                if (name.equals("Рама проходная (42х1,5)")) {
                    elementsBalance[1] = new ElementScaffold(name, weight, buyingPrice);
                }
                if (name.equals("Связь диагональная, l=3 м.")) {
                    elementsBalance[2] = new ElementScaffold(name, weight, buyingPrice);
                }
                if (name.equals("Связь горизонтальная, l=3 м.")) {
                    elementsBalance[3] = new ElementScaffold(name, weight, buyingPrice);
                }
                if (name.equals("Ригель настила, l=3 м.")) {
                    elementsBalance[4] = new ElementScaffold(name, weight, buyingPrice);
                }
                if (name.equals("Настил деревянный 1х1")) {
                    elementsBalance[5] = new ElementScaffold(name, weight, buyingPrice);
                }
                if (name.equals("Опора простая (пятки)")) {
                    elementsBalance[6] = new ElementScaffold(name, weight, buyingPrice);
                }
            }
            for (int i = 0; i < products.size(); i++) {
                String name = products.get(i).getName();
                String status = products.get(i).getStatus();
                int count = (int) products.get(i).getCount();

                if (name.equals("Рама с лестницей (42х1,5)")) {
                    if (status.equals("брак")) {
                        elementsBalance [0].defectiveCountAppend(count);
                    } else {
                        elementsBalance[0].countAppend(count);
                    }
                }
                if (name.equals("Рама проходная (42х1,5)")) {
                    if (status.equals("брак")) {
                        elementsBalance[1].defectiveCountAppend(count);
                    } else {
                        elementsBalance[1].countAppend(count);
                    }
                }
                if (name.equals("Связь диагональная, l=3 м.")) {
                    if (status.equals("брак")) {
                        elementsBalance[2].defectiveCountAppend(count);
                    } else {
                        elementsBalance[2].countAppend(count);
                    }
                }
                if (name.equals("Связь горизонтальная, l=3 м.")) {
                    if (status.equals("брак")) {
                        elementsBalance[3].defectiveCountAppend(count);
                    } else {
                        elementsBalance[3].countAppend(count);
                    }
                }
                if (name.equals("Ригель настила, l=3 м.")) {
                    if (status.equals("брак")) {
                        elementsBalance[4].defectiveCountAppend(count);
                    } else {
                        elementsBalance[4].countAppend(count);
                    }
                }
                if (name.equals("Настил деревянный 1х1")) {
                    if (status.equals("брак")) {
                        elementsBalance[5].defectiveCountAppend(count);
                    } else {
                        elementsBalance[5].countAppend(count);
                    }
                }
                if (name.equals("Опора простая (пятки)")) {
                    if (status.equals("брак")) {
                        elementsBalance[6].defectiveCountAppend(count);
                    } else {
                        elementsBalance[6].countAppend(count);
                    }
                }
            }
            return elementsBalance;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized List<StorageOperation> getOperationsList () {
        try {
            return talosRepo.getApi().loadOperations().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void editBalance(@NotNull ElementScaffold[] elementBalance) {
        try {
            int productId = 1;
            for (int i = 0; i < elementBalance.length; i++) {
                Product normalProduct = new Product(productId, elementBalance[i].getName(),"Ринстрой", "бу", elementBalance[i].getCount());
                talosRepo.getApi().editProduct(productId, normalProduct).execute();
                productId++;
                Product defectiveProduct = new Product(productId, elementBalance[i].getName(),"Ринстрой", "брак", elementBalance[i].getDefectiveCount());
                talosRepo.getApi().editProduct(productId, defectiveProduct).execute();
                productId++;
                talosRepo.getApi().editInfoData(i+1, new InfoData(i+1, elementBalance[i].getName(), elementBalance[i].getWeight(), (elementBalance[i].getBuyingPrice()/100)*115, elementBalance[i].getBuyingPrice(), 0.0)).execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized void createOperation (@NotNull StorageOperation operation) {
        try {
            talosRepo.getApi().createOperation(operation).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void editOperation (@NotNull StorageOperation operation) {
        try {
            talosRepo.getApi().editOperation(operation.getId(), operation).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
