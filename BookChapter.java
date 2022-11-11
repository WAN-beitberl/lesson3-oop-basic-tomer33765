import java.util.Currency;

public class BookChapter {
    public static String nearestChapter(Chapter[] chapter, int page)
    {
        int minDistance = Integer.MAX_VALUE;
        int currentDistance;
        String result = "";

        for (int i = 0; i < chapter.length; i++)
        {
            currentDistance = Math.abs(chapter[i].getPage() - page);
            
            if (currentDistance < minDistance)
            {
                minDistance = currentDistance;
                result = chapter[i].getName();
            }
        }

        return result;
    }
}

class Chapter {
    private String name;
    private int page;

    public Chapter(String name, int page) {
        this.name = name;
        this.page = page;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
}
